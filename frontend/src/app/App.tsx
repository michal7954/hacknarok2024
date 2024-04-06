import React from 'react';
import 'app/App.css';
import Panel from 'features/server/Panel';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from 'features/home/Home';

function App() {
  return (
    <div className="app">
    <Router>
      <Routes>
        <Route path="panel" element={<Panel />} />
        <Route path="*" element={<Home />} />
      </Routes>
    </Router>
  </div>
  )
}

export default App;
