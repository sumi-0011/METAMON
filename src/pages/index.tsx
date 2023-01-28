import Head from 'next/head';
import Onboarding from '@/components/pages/onboarding';
import Test from '@/components/pages/test';
import Layout from '@/components/common/layout';

export default function Home() {
  return (
    <Layout>
      <Onboarding />
    </Layout>
  );
}
