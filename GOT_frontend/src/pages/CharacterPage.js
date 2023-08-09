import React, { useState, useEffect } from 'react';
import { Box, Flex ,Image} from '@chakra-ui/react';
import HouseDropdown from '../components/HouseDropdown';
import FamilyTree from '../components/FamilyTree';
import CharacterCard from '../components/CharacterCard';
import axios from 'axios';

const logoImage = '/goth.png'; 
function CharacterPage() {
  const [selectedHouse, setSelectedHouse] = useState(null);
  const [familyTreeData, setFamilyTreeData] = useState([]);
  const [selectedCharacter, setSelectedCharacter] = useState(null);


  useEffect(() => {
    if (selectedHouse !== null) { // Check for null here
      axios.get(`http://localhost:8081/api/characters/familytree/${selectedHouse}`)
        .then(response => {
            setSelectedCharacter(null);
            console.log("response.data ::",response.data);
            let originalData = response.data;

//////////////////////////////////////////////////////////


  
  
//   const rootCharacter = findRootCharacter(response.data);
//   console.log("root character ::",rootCharacter);
//   const transformedData = createTreeData(response.data, rootCharacter.characterName);
  
//   console.log(JSON.stringify(transformedData, null, 2));


const buildTreeData = (characterName) => {
    const character = originalData.find(entry => entry.characterName === characterName);
    if (!character) return null;
//   console.log("character Image thumb",character);
    const treeItem = {
      name: character.characterName,
      attributes: {
        houseName: character.houseName,
        characterName: character.characterName,
        actorName: character.actorName,
        id: character.id,
        characterImageThumb : character.characterImageThumb,
        sibling : character.sibling,
        siblings: character.siblings,
        killed : character.killed,
        guardedBy : character.guardedBy,
        killedBy : character.killedBy,
        marriedEngaged : character.marriedEngaged,
        abductedBy : character.abductedBy,
        servedBy : character.servedBy,
        guardianOf : character.guardianOf,

        isFavourite: character.isFavourite || false,
      },
    };
  
    const children = originalData.filter(entry => entry.parents.includes(character.characterName));
    if (children.length > 0) {
      treeItem.children = children.map(child => buildTreeData(child.characterName));
    }
  
    return treeItem;
  };
  
  let treeData;
  if (originalData.length === 1) {
    treeData = buildTreeData(originalData[0].characterName);
    setFamilyTreeData([treeData]);
  } else {
    const rootCharacters = originalData.filter(entry => entry.parents.length === 0 && entry.parentOf.length > 0);
    treeData = rootCharacters.map(rootCharacter => buildTreeData(rootCharacter.characterName));
    setFamilyTreeData(treeData);
  }
  
  console.log(JSON.stringify(treeData, null, 2));


  















            
        //   setFamilyTreeData(treeData);
          
        })
        .catch(error => {
          console.error('Error fetching family tree data:', error);
        });
    }
  }, [selectedHouse]);
  





//   const findRootCharacter = (data) => {
//     const characterWithParentOf = new Set();
//     const characterWithoutParents = [];
  
//     data.forEach(entry => {
//       if (entry.parentOf.length > 0) {
//         entry.parentOf.forEach(childName => {
//           characterWithParentOf.add(childName);
//         });
//       } else {
//         characterWithoutParents.push(entry.characterName);
//       }
//     });
  
//     return characterWithoutParents.find(name => characterWithParentOf.has(name));
//   };



//   const buildTreeData = (characterName) => {
//     const character = originalData.find(entry => entry.characterName === characterName);
//     if (!character) return null;
  
//     const treeItem = {
//       name: character.characterName,
//       attributes: {
//         houseName: character.houseName,
//         isFavourite: character.isFavourite || false,
//       },
//     };
  
//     const children = originalData.filter(entry => entry.parents.includes(character.characterName));
//     if (children.length > 0) {
//       treeItem.children = children.map(child => buildTreeData(child.characterName));
//     }
  
//     return treeItem;
//   };

const handleSelectCharacter = (character) => {
    console.log("character ::",character)
    setSelectedCharacter(character);
  };


  
//   const createTreeData = (data, characterName) => {
//     const character = data.find(entry => entry.characterName === characterName);
//     if (!character) return null;
  
//     const treeItem = {
//       name: character.characterName,
//       attributes: {
//         houseName: character.houseName,
//         isFavourite: character.isFavourite || false,
//       },
//     };
  
//     const children = character.parentOf.map(childName => createTreeData(data, childName));
//     if (children.length > 0) {
//       treeItem.children = children;
//     }
  
//     return treeItem;
//   };
  

  const handleToggleFavorite = (characterId) => {
    if (selectedCharacter && selectedCharacter.id === characterId) {
      const updatedCharacter = { ...selectedCharacter };
      updatedCharacter.isFavourite = !updatedCharacter.isFavourite;
      setSelectedCharacter(updatedCharacter);
      
      axios.put(`http://localhost:8081/api/characters/${characterId}/favourite`) // Replace with your API endpoint
        .catch(error => {
          console.error('Error toggling favorite:', error);
        });
    }
  };

  return (
    
    <Box p="4">
         <Flex direction="column" alignItems="center">
        <Image src={logoImage} alt="Game of Thrones Logo" maxW="200px" mb="4" />
        
      </Flex>
      <HouseDropdown onSelectHouse={setSelectedHouse} />
      <Flex mt="4">
        <Box flex="1">
          {familyTreeData.length > 0 ? (
            <FamilyTree
              treeData={familyTreeData}
              onSelectCharacter={handleSelectCharacter}
            />
          ) : (
            <p>NO DATA PRESENT</p>
          )}
        </Box>
        <Box ml="4">
          {selectedCharacter && (
            <CharacterCard
              character={selectedCharacter}
              onToggleFavorite={handleToggleFavorite}
            />
          )}
        </Box>
      </Flex>
    </Box>
  );
}

export default CharacterPage;
