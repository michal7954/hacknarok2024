import { PostType } from 'features/server/defaultApi';
import Card from '@mui/material/Card';
import CardMedia from '@mui/material/CardMedia';
import { CardContent } from '@mui/material';
import Chip from '@mui/material/Chip';
import './Post.scss';
import ThumbUpAltIcon from '@mui/icons-material/ThumbUpAlt';
import VisibilityIcon from '@mui/icons-material/Visibility';

export default function Post({ post }: { post: PostType }) {
  return (
    <div className="post">
      <Card className="card">
        <CardMedia
          component="img"
          height="140"
          image="https://source.unsplash.com/random"
          alt="random"
        />
        <CardContent>
          {post.content}
          <div className="chips">
            <Chip
              label={<><VisibilityIcon /> {post.postStatisticReadDto.numberOfViews}</>}
              color="default"
              size="medium"
              variant="filled"
              className="chip"
            />
            <Chip
              label={<><ThumbUpAltIcon /> {post.postStatisticReadDto.numberOfLikes}</>}
              color="default"
              size="medium"
              variant="filled"
              className="chip"
            />
          </div>

        </CardContent>
      </Card>
    </div>
  );
}