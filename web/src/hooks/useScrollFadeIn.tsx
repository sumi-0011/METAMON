import { useRef, useEffect, useCallback, MutableRefObject } from 'react';
type DirectionType = 'up' | 'down' | 'left' | 'right';

const useScrollFadeIn = (
  direction: DirectionType = 'up',
  duration = 1,
  delay = 0,
) => {
  const element = useRef<any>();

  const handleDirection = (name: DirectionType) => {
    switch (name) {
      case 'up':
        return 'translate3d(0, 50%, 0)';
      case 'down':
        return 'translate3d(0, -50%, 0)';
      case 'right':
        return 'translate3d(50%, 0, 0)';
      case 'left':
        return 'translate3d(-50%, 0, 0)';
      default:
        return;
    }
  };

  const handleScroll = useCallback(
    ([entry]: any) => {
      const { current } = element;
      if (entry.isIntersecting) {
        current.style.transitionProperty = 'all';
        current.style.transitionDuration = `${duration}s`;
        current.style.transitionTimingFunction = 'cubic-bezier(0, 0, 0.2, 1)';
        current.style.transitionDelay = `${delay}s`;
        current.style.opacity = 1;
        current.style.transform = 'translate3d(0, 0, 0)';
      }
    },
    [delay, duration],
  );

  useEffect(() => {
    let observer: IntersectionObserver;
    const { current } = element;

    if (current) {
      observer = new IntersectionObserver(handleScroll, { threshold: 0.3 });
      observer.observe(current);
    }

    return () => observer && observer.disconnect();
  }, [handleScroll]);

  return {
    ref: element,
    style: {
      opacity: 0,
      transform: handleDirection(direction),
    },
  };
};

export default useScrollFadeIn;
