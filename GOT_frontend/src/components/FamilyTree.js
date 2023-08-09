import React from 'react';
// import { ContextMenu, MenuItem } from 'react-contextmenu';
import Tree from 'react-d3-tree';

function FamilyTree({ treeData, onSelectCharacter }) {

    console.log("tree data from child :::",treeData);
    const renderForeignObjectNode = ({ nodeDatum }) => (
        <foreignObject x={-70} y={-10} width={140} height={20}>
          <div
            style={{
              textAlign: 'center',
              border: '1px solid red',
            }}
            onClick={() => onSelectCharacter(nodeDatum.attributes)}
          >
            {nodeDatum.name}
          </div>
        </foreignObject>
      );



  const onClickNode = (_, targetNode) => {
    console.log("Node clicked",targetNode)
    onSelectCharacter(_.data.attributes);
  };

  return (
    <div style={{ position: 'relative', height: '100vh' }}>
  
      <Tree
        data={treeData}
        orientation="vertical"
        translate={{ x: 300, y: 50 }}
        // onClick={onClickNode}
        onNodeClick={onClickNode}
     
        nodeSvgShape={{
          shape: 'circle',
        }}
        renderCustomNodeElement={renderForeignObjectNode}
      />
    </div>
  );
}

export default FamilyTree;
