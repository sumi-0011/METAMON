import { requestPost } from '@/api';

const BASE =
  'http://ec2-15-164-169-134.ap-northeast-2.compute.amazonaws.com:8080';
const SIGN_UP_URL = BASE + '/v1/signup';
const EMAIL_URL = BASE + '/v1/email/confirm';

const sign_up = async (body: any) => {
  try {
    const { data } = await requestPost(SIGN_UP_URL, body);
    console.log('data: ', data);
    return data;
  } catch (error) {
    console.log('error: ', error);
  }
};

const confirmEmail = async (email: string) => {
  try {
    const url = EMAIL_URL + '?email=' + email;
    const { data } = await requestPost(url, {});
    return data;
  } catch (error) {
    return error.response.data;
  }
};

export { sign_up, confirmEmail };
