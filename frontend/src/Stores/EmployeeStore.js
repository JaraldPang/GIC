import { createStore, applyMiddleware } from 'redux';
import EmployeeReducer from '../Reducers/EmployeeReducer';
import thunk from "redux-thunk";
import { composeWithDevTools } from 'redux-devtools-extension';

function saveToLocal(state){
    try{
        const serializedState = JSON.stringify(state)
        localStorage.setItem('state', serializedState)
    } catch(e){
        console.log(e)
    }
}

function loadFromLocal(){
    try{
        const serializedState = localStorage.getItem('state')
        if (serializedState === null) return undefined
        return JSON.parse(serializedState)
    } catch(e){
        console.log(e)
        return undefined
    }
}

const persistedState = loadFromLocal()

const middelware = [thunk]

const employeeStore = createStore(EmployeeReducer, persistedState, composeWithDevTools(applyMiddleware(...middelware)));

employeeStore.subscribe(() => saveToLocal(employeeStore.getState()))

export default employeeStore;