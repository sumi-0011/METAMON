import styled from 'styled-components';

export const WrapperStyle = styled.div`
  --top-size: 16px;
  background-color: #fff;
  position: relative;

  max-width: 1600px;
  margin: 0 auto;
  font-size: var(--top-size);

  @media ${({ theme }) => theme.device.desktop} {
    --top-size: 16px;
  }
  @media ${({ theme }) => theme.device.laptop} {
    --top-size: 13px;
  }

  @media ${({ theme }) => theme.device.tablet} {
    --top-size: 8px;
  }

  @media ${({ theme }) => theme.device.mobile} {
    --top-size: 6px;
  }
`;

export const BigTitle = styled.div`
  font-size: 6em;
  font-weight: bold;
  letter-spacing: 0px;
  color: #010101;
`;

export const Desc = styled.div`
  font-size: 2.5em;
  font-weight: bold;

  letter-spacing: 0px;
  color: #676767;
`;

export const EmojiWrapperStyle = styled.div`
  position: absolute;

  @media ${({ theme }) => theme.device.laptop} {
    /* left: 500px; */
    img {
      width: 180px;
      height: 180px;
    }
  }

  @media ${({ theme }) => theme.device.tablet} {
    img {
      width: 140px;
      height: 140px;
    }
  }

  @media ${({ theme }) => theme.device.mobile} {
    img {
      width: 120px;
      height: 120px;
    }
  }
`;

export const LeftBox = styled.div`
  position: absolute;
  left: 254px;

  @media ${({ theme }) => theme.device.desktop} {
    left: 100px;
  }

  @media ${({ theme }) => theme.device.tablet} {
    left: 50px;
  }
  @media ${({ theme }) => theme.device.mobile} {
    left: 20px;
  }
`;

export const RightBox = styled.div`
  position: absolute;
  right: 0;
  text-align: right;
  right: 230px;

  @media ${({ theme }) => theme.device.desktop} {
    right: 100px;
  }
  @media ${({ theme }) => theme.device.mobile} {
    right: 20px;
  }
`;
