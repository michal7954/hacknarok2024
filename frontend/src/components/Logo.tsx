import React from 'react';
import { useNavigate } from 'react-router';
import './Logo.scss';

export default function Logo() {
  const navigate = useNavigate();

  return (
    <div className="logo" onClick={() => navigate('/')}>
      POST<br />
      GENERATOR
    </div>
  );
}