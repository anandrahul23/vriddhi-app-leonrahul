import React from 'react';
import { Input, InputGroup, InputLeftElement } from '@chakra-ui/react';
import { SearchIcon } from '@chakra-ui/icons';
import { useState } from 'react';
//import AlphaVantageServer from '../server/AlphaVantageServer';
import PolygonServer from '../server/PolygonServer';
import { useEffect } from 'react';
import TickerDetails from '../server/TickerDetails';


const CustomInput: React.FC = () => {
     const [searchTerm, setSearchTerm] = useState('');

    useEffect(() => {
        if (searchTerm.length > 3) {
            console.log(searchTerm); // This will log the search text in the browser console
            const ps = new PolygonServer();
            const tickerDetail: TickerDetails[] = ps.searchCache(searchTerm); 
            console.log(tickerDetail);
             
            // const avs = new AlphaVantageServer();
            // avs.getShares(searchTerm).then((data) => {
            //     console.log(data);
            // }
            // );
        }
    }, [searchTerm]);
    const handleSearchChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setSearchTerm(event.target.value);
    };
   
    return (
        <InputGroup>
            <InputLeftElement pointerEvents="none">
                <SearchIcon color="gray.300" />
            </InputLeftElement>
            <Input type="text" placeholder="Search..." onChange={handleSearchChange} value={searchTerm}/>
        </InputGroup>
    );
};

export default CustomInput;