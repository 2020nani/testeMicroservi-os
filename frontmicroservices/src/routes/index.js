import React from 'react';
import { Switch} from 'react-router-dom';
import { Route } from 'react-router-dom'
import Dashboard from '../pages/Dashboard'
export default function App() {
  return (
    <Switch>
      <Route path="/" exact component={Dashboard} />
      <Route path="/" component={() => <h1>404</h1>} />
    </Switch>
  );
}