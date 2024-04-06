import React from 'react';
import {
  useGetHelloQuery,
} from 'features/server/defaultApi';

export default function Panel() {
  const hello = useGetHelloQuery();

  return (
    <div>
      <p>Hello: {hello.data}</p>
    </div>
  );
}