import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';
import configuration from 'configuration.json';

const host = configuration.api.local.host;

type HelloWithContent = {
  content: string,
  path: string,
  language: string,
}

export const defaultApi = createApi({
  reducerPath: 'defaultApi',
  baseQuery: fetchBaseQuery({
    baseUrl: host,
  }),
  endpoints: (builder) => ({
    getHello: builder.query<string, void>({
      query: () => ({
        url: 'hello',
        responseHandler: 'text',
      }),
    }),
  }),
});


export const { useGetHelloQuery } = defaultApi;