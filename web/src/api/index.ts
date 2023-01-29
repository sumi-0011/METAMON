import axios from 'axios';
axios.defaults.withCredentials = true;

const requestPost = async (url: string, body: any) => {
  return await axios.post(url, body);
};

export { requestPost };
