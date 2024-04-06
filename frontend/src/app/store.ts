import { configureStore, ThunkAction, Action } from '@reduxjs/toolkit';
import counterReducer from '../features/counter/counterSlice';
import {defaultApi} from 'features/server/defaultApi';

export const store = configureStore({
  reducer: {
    counter: counterReducer,
    [defaultApi.reducerPath]: defaultApi.reducer,
  },
  middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(defaultApi.middleware),
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
export type AppThunk<ReturnType = void> = ThunkAction<
  ReturnType,
  RootState,
  unknown,
  Action<string>
>;
