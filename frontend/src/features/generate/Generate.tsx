import React from 'react';
import './Generate.scss';
import { Fab, TextField } from '@mui/material';
import PersonIcon from '@mui/icons-material/Person';
import AutoAwesomeIcon from '@mui/icons-material/AutoAwesome';
import { defaultApi } from 'features/server/defaultApi';
import { useNavigate } from 'react-router';
import Logo from 'components/Logo';
import { useAppDispatch } from 'app/hooks';
import { setGeneratedPosts, setMessage as setMessageToState } from 'features/counter/counterSlice';
import CircularProgress from '@mui/material/CircularProgress';
import Box from '@mui/material/Box';

export default function Generate() {
  const [ myStyle, setMyStyle ] = React.useState(true);
  const [ message, setMessage ] = React.useState('');
  const dispatch = useAppDispatch();
  const navigate = useNavigate();
  const [ isLoading, setIsLoading ] = React.useState(false);

  const handleGenerate = async () => {
    setIsLoading(true);
    dispatch(setMessageToState(message));
    const promise = dispatch(defaultApi.endpoints.getGeneratedPosts.initiate({
      message,
      myStyle,
    }));
    const { data /*...*/ } = await promise;
    dispatch(setGeneratedPosts(data || []));
    navigate('/choosePost');
  };

  return (
    <div className="generate">
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
      <div className="content">
        <div className="text-field-wrapper">
          <TextField
            id="prompt"
            label="Your prompt"
            multiline
            rows={4}
            placeholder="What you want to post about? Give some crucial information..."
            value={message}
            onChange={(e) => setMessage(e.target.value)}
          />
        </div>
        <div className="post-style-buttons">
          <Fab
            variant="extended"
            color="default"
            size="large"
            onClick={() => setMyStyle(true)}
            className={`post-style-buttons-fab ${myStyle ? 'post-style-buttons-fab--active' : ''}`}
          >
            USE MY STYLE
          </Fab>
          <Fab
            variant="extended"
            color="default"
            size="large"
            onClick={() => setMyStyle(false)}
            className={`post-style-buttons-fab ${!myStyle ? 'post-style-buttons-fab--active' : ''}`}
          >
            PROPOSE SOMETHING
          </Fab>
        </div>
        <div>
          <Fab
            variant="extended"
            color="default"
            size="large"
            onClick={handleGenerate}
            className="submit-button"
          >
            LET’S DO THE MAGIC {isLoading ?
            <Box sx={{ display: 'flex', marginLeft: '8px' }}>
              <CircularProgress size={20} />
            </Box>
            : <AutoAwesomeIcon sx={{ marginLeft: '8px' }} />}
          </Fab>
        </div>
      </div>
    </div>
  );
}