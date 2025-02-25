import React from 'react';
import Component, { ClassComponent, FunctionalComponent } from './component/Component';
import './App.css';
import CurlyBraces from './component/CurlyBraces';
import Properties from './component-manage/Properties';
import ConditionRender from './component-manage/ConditionRender';
import Profile from './component-manage/example/Example2';

function App() {
    return (
        <div>
            {/* <ClassComponent />
      <FunctionalComponent />
      <Component /> */}
            {/* <CurlyBraces /> */}
            {/* <Properties /> */}
            {/* <Profile /> */}
            <ConditionRender />
        </div>
    );
}

export default App;
