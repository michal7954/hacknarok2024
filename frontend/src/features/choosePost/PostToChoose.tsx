import { PostType, useAddPostMutation } from 'features/server/defaultApi';
import Card from '@mui/material/Card';
import CardMedia from '@mui/material/CardMedia';
import { CardContent, Fab } from '@mui/material';
import Chip from '@mui/material/Chip';
import './PostToChoose.scss';
import ThumbUpAltIcon from '@mui/icons-material/ThumbUpAlt';
import VisibilityIcon from '@mui/icons-material/Visibility';
import AddIcon from '@mui/icons-material/Add';
import React from 'react';

export default function PostToChoose({ post }: { post: string }) {
  const [ addPost ] = useAddPostMutation();
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
        onClick={() => addPost({
          content: post,
        })}
      >
        CHOOSE
      </Fab>
    </div>
  );
}