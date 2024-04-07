import { useAddPostMutation } from 'features/server/defaultApi';
import Card from '@mui/material/Card';
import CardMedia from '@mui/material/CardMedia';
import { CardContent, Fab } from '@mui/material';
import './PostToChoose.scss';
import React from 'react';
import { useNavigate } from 'react-router';

export default function PostToChoose({ post }: { post: string }) {
  const [addPost] = useAddPostMutation();
  const navigate = useNavigate();

  return (
    <div className="post-to-choose">
      <Card className="card">
        <CardMedia
          component="img"
          height="140"
          image="https://source.unsplash.com/random"
          alt="random"
        />
        <CardContent>
          {post}
        </CardContent>
      </Card>
      <Fab
        variant="extended"
        color="default"
        size="large"
        className="post-to-choose__fab"
        onClick={() => {
          addPost({
            content: post,
          });
          navigate('/');
        }}
      >
        CHOOSE
      </Fab>
    </div>
  );
}