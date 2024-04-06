import React from 'react';
import './Home.scss';
import { Avatar, Fab } from '@mui/material';
import PersonIcon from '@mui/icons-material/Person';
import AutoAwesomeIcon from '@mui/icons-material/AutoAwesome';
import AddIcon from '@mui/icons-material/Add';
import { useGetPostsQuery } from 'features/server/defaultApi';
import Post from 'features/home/Post';

export default function Home() {
  const {data: posts } = useGetPostsQuery();

  return (
    <div className="home">
      <nav className="nav">
        <Avatar alt="Avatar" variant="circular" className="avatar">
          <PersonIcon />
        </Avatar>
        <Fab
          variant="extended"
          color="default"
          size="large"
        >
          ADD EXISTING POST <AddIcon />
        </Fab>
        <Fab
          variant="extended"
          color="default"
          size="large"
        >
          GENERATE NEW POST <AutoAwesomeIcon />
        </Fab>
      </nav>
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