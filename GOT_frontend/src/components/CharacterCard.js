import React from 'react';
import { Box, Button, Text ,Image } from '@chakra-ui/react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHeart as solidHeart } from '@fortawesome/free-solid-svg-icons';
import { faHeart as regularHeart } from '@fortawesome/free-regular-svg-icons';


function CharacterCard({ character, onToggleFavorite }) {
  return (
    <Box borderWidth="1px" p="4" rounded="md">
      <Text><h4>Character Name :</h4>{character.characterName}</Text>
      {/* <Text>Actor Name ::{character.actorName}</Text> */}
      <Image src={character.characterImageThumb} alt={`${character.characterName} Image`} my={2} />
      

{character.sibling && character.sibling.length > 0 ? (
        <Box>
          <Text><h4>Sibling:</h4></Text>
          <ul>
            {character.sibling.map((s, index) => (
              <li key={index}>{s}</li>
            ))}
          </ul>
        </Box>
      ) : null}
      {character.siblings && character.siblings.length > 0 ? (
        <Box>
          <Text><h4>Siblings:</h4></Text>
          <ul>
            {character.siblings.map((s, index) => (
              <li key={index}>{s}</li>
            ))}
          </ul>
        </Box>
      ) : null}



{character.killed && character.killed.length > 0 ? (
        <Box>
          <Text><h4>Killed:</h4></Text>
          <ul>
            {character.killed.map((k, index) => (
              <li key={index}>{k}</li>
            ))}
          </ul>
        </Box>
      ) : null}



{character.guardedBy && character.guardedBy.length > 0 ? (
        <Box>
          <Text><h4>Guarded By:</h4></Text>
          <ul>
            {character.guardedBy.map((g, index) => (
              <li key={index}>{g}</li>
            ))}
          </ul>
        </Box>
      ) : null}



{character.killedBy && character.killedBy.length > 0 ? (
        <Box>
          <Text><h4>Killed By:</h4></Text>
          <ul>
            {character.killedBy.map((k, index) => (
              <li key={index}>{k}</li>
            ))}
          </ul>
        </Box>
      ) : null}



{character.marriedEngaged && character.marriedEngaged.length > 0 ? (
        <Box>
          <Text><h4>Married/Engaged:</h4></Text>
          <ul>
            {character.marriedEngaged.map((m, index) => (
              <li key={index}>{m}</li>
            ))}
          </ul>
        </Box>
      ) : null}



{character.abductedBy && character.abductedBy.length > 0 ? (
        <Box>
          <Text><h4>Abducted By:</h4></Text>
          <ul>
            {character.abductedBy.map((a, index) => (
              <li key={index}>{a}</li>
            ))}
          </ul>
        </Box>
      ) : null}



{character.servedBy && character.servedBy.length > 0 ? (
        <Box>
          <Text><h4>Served By:</h4></Text>
          <ul>
            {character.servedBy.map((s, index) => (
              <li key={index}>{s}</li>
            ))}
          </ul>
        </Box>
      ) : null}


{character.guardianOf && character.guardianOf.length > 0 ? (
        <Box>
          <Text><h4>Guardian Of:</h4></Text>
          <ul>
            {character.guardianOf.map((g, index) => (
              <li key={index}>{g}</li>
            ))}
          </ul>
        </Box>
      ) : null}



      <Button onClick={() => onToggleFavorite(character.id)}>
        {character.isFavourite ? (
          <FontAwesomeIcon icon={solidHeart} size="lg" color="red" />
        ) : (
          <FontAwesomeIcon icon={regularHeart} size="lg" />
        )}
      </Button>
    </Box>
  );
}

export default CharacterCard;
