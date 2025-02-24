import React from 'react';
import './App.css';
import Component, { ClassComponent, FunctionalComponent } from './component/Component';

function App() {
    return (
        <div>
            <ClassComponent></ClassComponent>
            <FunctionalComponent />
        </div>
    );
}

export default App;
