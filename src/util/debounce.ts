const debounceFunction = (callback: any, delay: number) => {
  let timer: number | NodeJS.Timeout;
  return (...args: any[]) => {
    // 실행한 함수(setTimeout())를 취소
    clearTimeout(timer);
    // delay가 지나면 callback 함수를 실행
    timer = setTimeout(() => callback(...args), delay);
  };
};

export default debounceFunction;
