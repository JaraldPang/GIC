import React, { Component } from 'react';
import '../Styles/App.css';
import { Provider } from 'react-redux';
import { BrowserRouter , Redirect, Route, Switch } from 'react-router-dom';
import HomePage from '../Pages/HomePage';
import employeeStore from '../Stores/EmployeeStore';
import EditPage from '../Pages/EditPage';

class App extends Component {
  render(){
    return (
        <Provider store={employeeStore}>
          <BrowserRouter>
            <Switch>
              <Route path = '/' exact={true}>
                <Redirect to='/employee/list'/>
              </Route>
              <Route path='/employee/list' exact={true} component={HomePage} />
              <Route path='/employee/add' exact={true} component={EditPage}/>
              <Route path='/employee/edit' exact={true} component={EditPage}/>
            </Switch>
          </BrowserRouter>
        </Provider>
    );
  }
}

export default App;