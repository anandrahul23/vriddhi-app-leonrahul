import React from 'react';
import { Tabs, TabList, TabPanels, Tab, TabPanel } from '@chakra-ui/react';
import CustomAccordion from './CustomAccordion';
import CustomInput from './CustomInput';
import { useEffect } from 'react';
import PolygonServer from '../server/PolygonServer';



interface Share {
    name: string;
    price: number;
    exchange: string;
    symbol: string;
    description: string;
}
interface Watchlist {
    title: string;
    shares: Share[];
}

export interface CustomTabsProps {
    title: string;
    watchlists: Watchlist[];
    content: React.ReactNode;
}

const CustomTabs: React.FC<CustomTabsProps> = (props) => {

    useEffect(() => {
        const ps = new PolygonServer();
        ps.getAllTickerDetails().then((data) => {
            console.log(data);
        }
        );
    }, []);
    return (
        <Tabs>
            <TabList>
               {props.watchlists.map((wl, index) => (
                    <Tab key={index}>{wl.title}</Tab>
                ))}
            </TabList>

            <CustomInput />

            <TabPanels>
                {props.watchlists.map((wl, index) => (
                    <TabPanel key={index}>
                        {wl.shares.map((share, index) => (
                            <CustomAccordion key={index} title={`${share.name} 
                             ${share.symbol} ${share.price}  ${share.exchange}`} 
                            content={<p>{share.description}</p>} />
                        ))}
                    </TabPanel>
                ))}
            </TabPanels>
        </Tabs>
    );
};

export default CustomTabs;