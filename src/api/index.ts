import axios from 'axios';

const requestGET = async (url: string, param: any) => {
  try {
    const data = await axios.get('url', param);
    console.log('data: ', data);
  } catch (error) {
    console.log('error: ', error);
    // 오류 발생시 실행
  }
};

const requestPost = async (url: string, body: any) => {
  return await axios.post(url, body);
  // try {
  //   const response =
  //   console.log('response: ', response);
  // } catch (error) {
  //   console.log('error: ', error);
  // }
};

export { requestPost, requestGET };
