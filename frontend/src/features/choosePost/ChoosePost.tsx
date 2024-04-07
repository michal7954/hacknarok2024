import React from 'react';
import './ChoosePost.scss';
import { Avatar, Fab } from '@mui/material';
import PersonIcon from '@mui/icons-material/Person';
import AutoAwesomeIcon from '@mui/icons-material/AutoAwesome';
import AddIcon from '@mui/icons-material/Add';
import { useGetPostsQuery } from 'features/server/defaultApi';
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
          <Avatar alt="Avatar" variant="circular" className="avatar">
            <PersonIcon />
          </Avatar>
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