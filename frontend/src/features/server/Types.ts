export type HelloWithContent = {
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

export type GeneratePostRequest = {
  message: string,
  myStyle: boolean,
}

export type GeneratePostResponse = [string, string, string]

export type AddPostRequest = {
  content: string,
}
