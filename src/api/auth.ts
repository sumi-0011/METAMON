import { requestPost } from '@/api';

const SIGN_UP_URL = '/v1/signup';

const sign_up = async () => {
  try {
    const data = await requestPost(SIGN_UP_URL, {});
    console.log('data: ', data);
  } catch (error) {
    console.log('error: ', error);
  }
};

export { sign_up };
