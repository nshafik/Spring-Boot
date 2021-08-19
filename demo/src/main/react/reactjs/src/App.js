import React, {useState,useEffect} from "react";
import { useTable, useSortBy } from "react-table";
import ReactTable from "react-table";

import InfiniteScroll from "react-infinite-scroll-component";
import makeData from "./generatedata";

import styled from "styled-components";



import logo from './logo.svg';
import './App.css';
import axios from "axios";




function Table({ columns, data, update }) {
  // Use the state and functions returned from useTable to build your UI

  const {
    getTableProps,
    getTableBodyProps,
    headerGroups,
    rows,
    prepareRow,
    state: { sortBy }
  } = useTable(
    {
      columns,
      data
    },
    useSortBy
  );

  React.useEffect(() => {
    console.log("sort");
  }, [sortBy]);

  // Render the UI for your table
  return (
    <InfiniteScroll
      dataLength={rows.length}
      next={update}
      hasMore={true}
      loader={<h4>Loading more 2 items...</h4>}
    >
      <table {...getTableProps()}>
        <thead>
          {headerGroups.map(headerGroup => (
            <tr {...headerGroup.getHeaderGroupProps()}>
              {headerGroup.headers.map(column => (
                <th {...column.getHeaderProps(column.getSortByToggleProps())}>
                  {column.render("Header")}
                  <span>
                    {column.isSorted
                      ? column.isSortedDesc
                        ? " 🔽"
                        : " 🔼"
                      : ""}
                  </span>
                </th>
              ))}
            </tr>
          ))}
        </thead>

        <tbody {...getTableBodyProps()}>
          {rows.map((row, i) => {
            prepareRow(row);
            return (
              <tr {...row.getRowProps()}>
                {row.cells.map(cell => {
                  return (
                    <td {...cell.getCellProps()}>{cell.render("Cell")}</td>
                  );
                })}
              </tr>
            );
          })}
        </tbody>
      </table>
    </InfiniteScroll>
  );
}


const Student=() => {
    const[student,setStudent] = useState(makeData(40));

    const columns = React.useMemo(
        () => [
          {

                Header: "id",
                accessor: "id"
              },
              {
                Header: "Name",
                accessor: "name"
              }
            ,

              {
                Header: "Age",
                accessor: "age"
              },
//              {
//                Header: "Date Of Birth",
//                accessor: "dob"
//              },
              {
                Header: "Email",
                accessor: "email"
              }
            ]
              );




//    const fetchStudentProfiles = () =>{
//        axios.get("http://localhost:8080/api/v2/student").then(res =>{
//        console.log(res);
//        setStudent(res.data);
//        });
//    }
      const fetchMoreData = () => {
        setTimeout(() => {
          setStudent(student.concat(makeData(2)));
        }, 1500);
      };

    const data = React.useMemo(() => student, [student]);

//    useEffect(()=>{
//    fetchStudentProfiles();
//    }, []);
        return(
      <Table columns={columns} data={data} update={fetchMoreData} />

         );
    }


function App() {
return (<div className="App">

          <Student />

</div>);
}

export default App;
