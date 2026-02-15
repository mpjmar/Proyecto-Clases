// This file provides utility functions for managing lists of game elements, such as counting characters.

const ListUtils = {
    countCharacters: function(elements, type) {
        return elements.filter(element => element.constructor.name === type).length;
    },

    displayState: function(elements) {
        return elements.map(element => `${element.constructor.name} - Life: ${element.life}`).join('\n');
    }
};

export default ListUtils;