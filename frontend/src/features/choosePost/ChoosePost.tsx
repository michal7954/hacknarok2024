import React from 'react';
import './ChoosePost.scss';
import { Fab } from '@mui/material';
import PersonIcon from '@mui/icons-material/Person';
import PostToChoose from 'features/choosePost/PostToChoose';
import { useNavigate } from 'react-router';
import Logo from 'components/Logo';
import { useSelector } from 'react-redux';
import { RootState } from 'app/store';

export default function ChoosePost() {
  const posts = useSelector((state: RootState) => state.counter.generatedPosts);
  const navigate = useNavigate();

  return (
    <div className="choose-post">
      <div className="header">
        <Logo />
        <nav className="nav">
          <Fab
            variant="circular"
            color="default"
            size="medium"
            onClick={() => navigate('/userInfo')}
          >
            <PersonIcon />
          </Fab>
        </nav>
      </div>
      <div className="posts">
        {
          posts?.map((post) => (
            <PostToChoose key={post} post={post} />
          ))
        }
      </div>
    </div>
  );
}