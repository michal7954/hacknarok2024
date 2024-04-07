export type GeneratePostRequest = {
  message: string,
  myStyle: boolean,
}

export type GeneratePostResponse = [string, string, string]

export type AddPostRequest = {
  content: string,
}
