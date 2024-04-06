import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';
import configuration from 'configuration.json';
import { GeneratePostRequest, GeneratePostResponse } from 'features/server/Types';

const host = configuration.api.local.host;

type HelloWithContent = {
  content: string,
  path: string,
  language: string,
}

export type PostType = {
  id: number,
  content: string,
  postStatisticReadDto: {
    'id': number,
    'numberOfViews': number,
    'numberOfLikes': number,
    'numberOfComments': number,
    'numberOfShares': number,
    'engagementRate': number,
    'numberOfImpressions': number,
    'reach': number,
    'clickThroughRate': number,
    'conversionRate': number,
    'averageTimeSpent': number,
  }
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
    getPosts: builder.query<Array<PostType>, void>({
      query: () => ({
        url: '/api/v1/author/posts',
      }),
    }),
    getGeneratedPosts: builder.query<GeneratePostResponse, GeneratePostRequest>({
      query: (body) => ({
        url: '/generatePostUsingMyStyle',
        method: 'POST',
        body,
      }),
    }),
  }),
});


export const { useGetHelloQuery, useGetPostsQuery, useGetGeneratedPostsQuery } = defaultApi;