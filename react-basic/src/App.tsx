import React from 'react';
import Component, { ClassComponent, FunctionalComponent } from './component/Component';
import './App.css';
import CurlyBraces from './component/CurlyBraces';
import Properties from './component-manage/Properties';
import ConditionRender from './component-manage/ConditionRender';
import Profile from './component-manage/example/Example2';
import ListRender from './component-manage/ListRender';
import EventComponent from './interaction/EventComponent';
import StateComponent from './interaction/StateComponent';
import ForwardingComponent from './interaction/ForwardingComponent';
import HookComponent2 from './hook/HookComponent2';
import HookComponent1 from './hook/HookComponent1';

function App() {
    return (
        <div>
            {/* <ClassComponent />
      <FunctionalComponent />
      <Component /> */}
            {/* <CurlyBraces /> */}
            {/* <Properties /> */}
            {/* <Profile /> */}
            {/* <ConditionRender /> */}
            {/* <ListRender/> */}
            {/* <EventComponent /> */}
            {/* <StateComponent /> */}
            {/* <ForwardingComponent /> */}
            {/* <HookComponent1 /> */}
            <HookComponent2 />
        </div>
    );
}

export default App;
