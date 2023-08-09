import React, { useState, useEffect } from 'react';
import { Select } from '@chakra-ui/react';
import axios from 'axios';

function HouseDropdown({ onSelectHouse }) {
  const [houseNames, setHouseNames] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8081/api/characters/houses') // Replace with your API endpoint
      .then(response => {
        setHouseNames(response.data);
      })
      .catch(error => {
        console.error('Error fetching house names:', error);
      });
  }, []);

  return (
    <Select onChange={(e) => onSelectHouse(e.target.value)}>
      <option value="">Select a House</option>
      {houseNames.map((houseName) => (
        <option key={houseName} value={houseName}>
          {houseName}
        </option>
      ))}
    </Select>
  );
}

export default HouseDropdown;
