const EMAIL_REGEX = new RegExp('[a-z0-9]+@[a-z]+.[a-z]{2,3}');
const PASSWORD_REGEX =
  /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

const validEmail = (email: string) => {
  if (!EMAIL_REGEX.test(email)) {
    // alert('이메일 정규식 규칙 위반!!');
    return { isValid: false, message: '이메일 정규식 규칙 위반!!' };
  }
  return { isValid: true };
};

const validPassword = (password: string) => {
  // NOTE : 특수문자 / 문자 / 숫자 포함 형태의 8~15자리 이내의 암호 정규식 (3 가지 조합)
  if (!PASSWORD_REGEX.test(password)) {
    return { isValid: false, message: '비밀번호 규칙 위반!!' };
  }

  return { isValid: true };
};

export { validPassword, validEmail };
