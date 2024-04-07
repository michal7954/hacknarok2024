import React from 'react';
import { createRoot } from 'react-dom/client';
import { Provider } from 'react-redux';
import { store } from 'app/store';
import App from 'app/App';
import 'index.css';
import { ThemeProvider, createTheme } from "@mui/material";
import { StyledEngineProvider } from '@mui/material/styles';
import {
  experimental_extendTheme as extendTheme,
  Experimental_CssVarsProvider as CssVarsProvider,
} from '@mui/material/styles';

const container = document.getElementById('root')!;
const root = createRoot(container);

const theme = createTheme();

root.render(
  // <React.StrictMode>
  <Provider store={store}>
    <StyledEngineProvider injectFirst>
      <ThemeProvider theme={theme}>
        <CssVarsProvider theme={extendTheme(theme)}>
          <App />
        </CssVarsProvider>
      </ThemeProvider>
    </StyledEngineProvider>
  </Provider>,
  // </React.StrictMode>
);