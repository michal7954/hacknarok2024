## About the app

Hackathon-winning ([LinkedIn post](https://www.linkedin.com/posts/patrykjanas27_hacknarok-eestec-winners-activity-7183157208472281088-vZ-Z?utm_source=share&utm_medium=member_desktop)), full-stack application supported by AI.\
It's a cross-platform content management tool for internet creators that maximizes a potential of generative AI in their everyday tasks.

## Frontend
All frontend codebase has been developed by [Michael Madeja](https://github.com/michal7954).

Technical files worth mentioning:
- Declarative definition of the complete app API using RTK Query - [file](https://github.com/michal7954/hacknarok2024/blob/master/frontend/src/features/server/defaultApi.ts). Example:
```TS
    getPosts: builder.query<Array<PostType>, void>({
      query: () => ({
        url: '/api/v1/author/posts',
      }),
      providesTags: ['Post'],
    }),
    addPost: builder.mutation<void, AddPostRequest>({
      query: (body) => ({
        url: '/api/v1/author/posts',
        method: 'POST',
        body,
      }),
      invalidatesTags: ['Post'],
    }),
```
Usage:
```TS
const { data: posts } = useGetPostsQuery();
const [ addPost ] = useAddPostMutation();

onClick={() => addPost({
  content: text,
})}
```

- Uncommon approach for triggering server state mutation in [file](https://github.com/michal7954/hacknarok2024/blob/master/frontend/src/features/generate/Generate.tsx):
```TS
  const [ message, setMessage ] = React.useState('');
  const [ isLoading, setIsLoading ] = React.useState(false);
  const dispatch = useAppDispatch();
  const navigate = useNavigate();

  const handleGenerate = async () => {
    setIsLoading(true);
    dispatch(setMessageToState(message));
    const promise = dispatch(defaultApi.endpoints.getGeneratedPosts.initiate({
      message,
      myStyle,
    }));
    const { data } = await promise;
    dispatch(setGeneratedPosts(data || []));
    navigate('/choosePost');
  };
```

## Development
To start up the project use:
```
docker-compose -f .\docker-compose-local.yml up
```
