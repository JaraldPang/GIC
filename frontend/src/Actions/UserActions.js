import employeeAPI from '../Axios/API';
import * as action from './ActionTypes';

export function getEmployees(){
    return function (dispatch) {
        return employeeAPI.get().then(result => {
            dispatch({type: action.GET_EMPLOYEES, payload: result.data})
        }).catch(error => console.log(error))
    }
}

export function addEmployee(newEmployee){
    return function (dispatch){
        return dispatch({type: action.ADD_EMPLOYEE, payload: newEmployee})
    }
}

export function editEmployee(updatedEmployee){
    return function(dispatch){
        return dispatch({type: action.EDIT_EMPLOYEE, payload: updatedEmployee})
    }
}

export function selectEmployee(selectEmployee){
    return function(dispatch){
        return dispatch({type: action.SELECT_EMPLOYEE, payload: selectEmployee})
    }
}

export function deleteEmployee(deleteEmployee){
    return function(dispatch){
        return dispatch({type: action.DELETE_EMPLOYEE, payload: deleteEmployee})
    }
}