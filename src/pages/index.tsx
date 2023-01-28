import Head from 'next/head';
import Onboarding from '@/components/pages/onboarding';
import Test from '@/components/pages/test';

export default function Home() {
  return (
    <>
      <main>
        <Onboarding />
      </main>
    </>
  );
}
