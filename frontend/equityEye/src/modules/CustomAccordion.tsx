import React from 'react';
import { Accordion, AccordionItem, AccordionButton, AccordionPanel, AccordionIcon, Box } from '@chakra-ui/react';

interface CustomAccordionProps {
    title: string;
    content: React.ReactNode;
}

//type CustomAccordionType = React.PropsWithChildren<CustomAccordionProps>;

const CustomAccordion: React.FC<CustomAccordionProps> = ({ title, content }) => {
    return (
        <Accordion allowToggle>
            <AccordionItem>
                <h2>
                    <AccordionButton>
                        <Box flex="1" textAlign="left">
                            {title}
                        </Box>
                        <AccordionIcon />
                    </AccordionButton>
                </h2>
                <AccordionPanel pb={4}>
                    {content}
                </AccordionPanel>
            </AccordionItem>
        </Accordion>
    );
};

export default CustomAccordion;

