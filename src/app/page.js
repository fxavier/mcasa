import React from 'react'

import Home from './home/page'
import Wrapper from "./layout-wrapper/wrapper";

export const metadata = {
  title: "Home || mCasa - Real Estate",
};

const MainRoot = () => {
  return (
    <Wrapper>
      <Home />
    </Wrapper>
  );
}

export default MainRoot