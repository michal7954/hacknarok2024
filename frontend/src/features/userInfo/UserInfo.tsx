import React from 'react';
import './UserInfo.scss';
import { Fab, TextField } from '@mui/material';
import PersonIcon from '@mui/icons-material/Person';
import { defaultApi, useSetUserInfoMutation } from 'features/server/defaultApi';
import { useNavigate } from 'react-router';
import Logo from 'components/Logo';
import { useAppDispatch } from 'app/hooks';

export default function UserInfo() {
  const [ setUserInfo ] = useSetUserInfoMutation();
  const dispatch = useAppDispatch();
  const navigate = useNavigate();

  const [ yourInfo, setYourInfo ] = React.useState( '');
  const [ followersInfo, setFollowersInfo ] = React.useState('');

  React.useEffect(() => {
    const setFormData = async () => {
      const promise = dispatch(defaultApi.endpoints.getUserInfo.initiate());
      const { data} = await promise;
      setYourInfo(data?.yourInfo || '');
      setFollowersInfo(data?.followersInfo || '');
    }
    void setFormData();
  }, []);

  const handleSave = () => {
    setUserInfo({ yourInfo, followersInfo });
    navigate('/')
  };

  return (
    <div className="user-info">
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
            id="you"
            label="Who you are?"
            multiline
            rows={4}
            placeholder="I am a Java developer with 5 years of experience and..."
            value={yourInfo}
            onChange={(e) => setYourInfo(e.target.value)}
          />
        </div>
        <div className="text-field-wrapper">
          <TextField
            id="followers"
            label="Who are your followers?"
            multiline
            rows={4}
            placeholder="Young people that..."
            value={followersInfo}
            onChange={(e) => setFollowersInfo(e.target.value)}
          />
        </div>
        <div>
          <Fab
            variant="extended"
            color="default"
            size="large"
            onClick={handleSave}
            className="submit-button"
          >
            SAVE
          </Fab>
        </div>
      </div>
    </div>
  );
}