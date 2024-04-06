import React from 'react';
import 'app/App.css';
import Panel from 'features/server/Panel';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="user" element={<p>User panel</p>} />
        <Route path="*" element={<Panel />} />
      </Routes>
    </Router>
  )
}

export default App;
