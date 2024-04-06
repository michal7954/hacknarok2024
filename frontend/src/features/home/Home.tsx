import React from 'react';
import './Home.scss';
import { Avatar, Fab } from '@mui/material';
import PersonIcon from '@mui/icons-material/Person';
import AutoAwesomeIcon from '@mui/icons-material/AutoAwesome';
import AddIcon from '@mui/icons-material/Add';
import { useGetPostsQuery } from 'features/server/defaultApi';
import Post from 'features/home/Post';
import { useNavigate } from 'react-router';
import Logo from 'components/Logo';

export default function Home() {
  const {data: posts } = useGetPostsQuery();
  const navigate = useNavigate();

  return (
    <div className="home">
      <div className="header">
        <Logo />
        <nav className="nav">
          <Fab
            variant="extended"
            color="default"
            size="large"
          >
            ADD EXISTING POSTS <AddIcon />
          </Fab>
          <Fab
            variant="extended"
            color="default"
            size="large"
            onClick={() => navigate('/generate')}
          >
            GENERATE NEW POST <AutoAwesomeIcon />
          </Fab>
          <Avatar alt="Avatar" variant="circular" className="avatar">
            <PersonIcon />
          </Avatar>
        </nav>
      </div>
      <div className="posts">
        {
          posts?.map((post) => (
            <Post key={post.id} post={post} />
          ))
        }
      </div>
    </div>
  );
}