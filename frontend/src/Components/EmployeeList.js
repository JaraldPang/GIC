import React, { useEffect, useState } from 'react';
import { Button, Table } from 'reactstrap';
import { connect } from "react-redux";
import employeeAPI from '../Axios/API';

import '../Styles/Body.css';
import { getEmployees } from '../Actions/UserActions';
import EmployeeTable from './EmployeeTable';


function mapStateToProps(state){
        return {
            allEmployees: state.allEmployees,
            selectedEmployee: state.selectedEmployee
        }
    }

function mapDispatchToProps(dispatch){
    return{
        getEmployees: () => dispatch(getEmployees())
    }
}

function EmployeeList(props){
    const [allEmployees, setAllEmployees] = useState([]);
    const [isReady, setIsReady] = useState(false);
    async function getData(){
        await employeeAPI.get().then(result => {
            setAllEmployees(result.data)
        }).catch(error => console.log(error));
    }
    useEffect(()=> {
        getData();
        setIsReady(true);
    }, [])

    return (
        <div className='Body'>
            <div style={{position:"absolute", right:"5%"}}>
                <Button color="success" onClick={()=>{}}>Add Employee</Button>
            </div>
            {isReady && <EmployeeTable allEmployees={allEmployees}/>}
        </div>
    )
}

export default connect(mapStateToProps, mapDispatchToProps)(EmployeeList);