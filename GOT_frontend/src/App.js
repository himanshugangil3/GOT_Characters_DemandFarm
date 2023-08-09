import React from 'react';
import { BrowserRouter as Router, Route, Routes  } from 'react-router-dom';
import CharacterPage from './pages/CharacterPage';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<CharacterPage/>} />
        </Routes>
    </Router>
  );
}

export default App;
