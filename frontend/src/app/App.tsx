import React from 'react';
import 'app/App.css';
import Panel from 'features/server/Panel';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from 'features/home/Home';
import Generate from 'features/generate/Generate';

function App() {
  return (
    <div className="app">
    <Router>
      <Routes>
        <Route path="panel" element={<Panel />} />
        <Route path="generate" element={<Generate />} />
        <Route path="*" element={<Home />} />
      </Routes>
    </Router>
  </div>
  )
}

export default App;
