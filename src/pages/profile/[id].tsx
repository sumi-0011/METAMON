import { useRouter } from 'next/router';
import styled from 'styled-components';

function Profile() {
  const router = useRouter();
  const { id } = router.query;

  return (
    <Wrapper>
      <Header>Profile {id}</Header>
      <InnerWrapper>
        <div>
          <Label>이름</Label>
          <div>수미 </div>
        </div>
        <Divider />
        <div>
          <Label>이메일</Label>
          <div>selina2000@naver.com </div>
        </div>
        <Divider />

        <div>
          <Label>생년월일</Label>
          <div>2000.11.12 </div>
        </div>
      </InnerWrapper>
    </Wrapper>
  );
}

const Divider = styled.hr`
  border: 0.5px solid #eee;
  margin: 5px 0;
`;
const Wrapper = styled.div`
  max-width: 375px;
  width: 100%;
  min-width: 300px;
  margin: auto;

  display: flex;
  flex-direction: column;
  background-color: #5e5edd;
  padding: 30px 20px;

  color: #454545;
  height: 100%;
  min-height: 100vh;
`;

const Header = styled.h1`
  color: #fff;
  font-size: 1.2rem;
  margin: 10px 0;
`;
const InnerWrapper = styled.div`
  background-color: #fff;
  border-radius: 15px;
  padding: 30px 20px;

  display: flex;
  flex-direction: column;
  gap: 10px;
`;

const Label = styled.div`
  color: #a9a7a2;
  font-size: 0.8rem;
  margin-bottom: 10px;
`;

export default Profile;
