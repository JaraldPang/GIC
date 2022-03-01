import React, { useEffect } from 'react';
import { Button } from 'reactstrap';
import { connect } from "react-redux";

import '../Styles/Body.css';
import { useHistory } from "react-router-dom";
import { getEmployees } from '../Actions/UserActions';
import EmployeeTable from './EmployeeTable';


function mapStateToProps(state){
        return {
            allEmployees: state.allEmployees,
            isReady: state.isReady
        }
    }

function mapDispatchToProps(dispatch){
    return{
        getEmployees: () => dispatch(getEmployees())
    }
}


function EmployeeList(props){
    useEffect(()=> {
        props.getEmployees();
    }, [])

    let history = useHistory();
    const routeToAddPage = () =>{
        history.push('/employee/add')
    }

    return (
        <div>
            <div style={{position:"absolute", right:"5%"}}>
                <Button color="success" onClick={()=>{routeToAddPage()}}>Add Employee</Button>
            </div>
            {props.isReady && <EmployeeTable allEmployees={props.allEmployees}/>}
        </div>
    )
}

export default connect(mapStateToProps, mapDispatchToProps)(EmployeeList);