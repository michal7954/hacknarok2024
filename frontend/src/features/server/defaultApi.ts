import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';
import configuration from 'configuration.json';
import { AddPostRequest, GeneratePostRequest, GeneratePostResponse, PostType } from 'features/server/Types';

const host = configuration.api.local.host;

export const defaultApi = createApi({
  reducerPath: 'defaultApi',
  baseQuery: fetchBaseQuery({
    baseUrl: host,
  }),
  tagTypes: ['Post'],
  endpoints: (builder) => ({
    getHello: builder.query<string, void>({
      query: () => ({
        url: 'hello',
        responseHandler: 'text',
      }),
    }),
    getPosts: builder.query<Array<PostType>, void>({
      query: () => ({
        url: '/api/v1/author/posts',
      }),
      providesTags: ['Post'],
    }),
    getGeneratedPosts: builder.query<GeneratePostResponse, GeneratePostRequest>({
      query: (body) => ({
        url: '/generatePostUsingMyStyle',
        method: 'POST',
        body,
      }),
    }),
    addPost: builder.mutation<void, AddPostRequest>({
      query: (body) => ({
        url: '/api/v1/author/posts',
        method: 'POST',
        body,
      }),
      invalidatesTags: ['Post'],
    }),
  }),
});


export const {
  useGetHelloQuery,
  useGetPostsQuery,
  useGetGeneratedPostsQuery,
  useAddPostMutation,
} = defaultApi;