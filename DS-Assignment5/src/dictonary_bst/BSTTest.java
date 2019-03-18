package dictonary_bst;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import org.junit.jupiter.api.Test;


class BSTTest
{
	@Test
	void testInorder()
	{
		BST bst = new BST();

		String[] keys = {"la", "ha", "ta", "na", "da"};
		String[] values = {"yes", "no", "han", "fss", "fgh"};

		bst.addArray(keys, values);

		bst.inorderRecord(bst.root);

		String[] keyList = new String[keys.length];

		bst.inorderKeyList.toArray(keyList);

		String[] testKeyList = {"da", "ha", "la", "na", "ta"};

		assertEquals(true, Arrays.deepEquals(keyList, testKeyList));		
	}

	@Test
	void testSearch()
	{
		BST bst = new BST();

		String[] keys = {"la", "ha", "ta", "na", "da"};
		String[] values = {"yes", "no", "han", "fss", "fgh"};

		bst.addArray(keys, values);
		bst.inorderRecord(bst.root);

		Node expectedSearch = bst.searchNode("ha");

		assertEquals(true, expectedSearch.value.equals("no"));
	}

	@Test
	void testDelete()
	{
		BST bst = new BST();

		String[] keys = {"la", "ha", "ta", "na", "da"};
		String[] values = {"yes", "no", "han", "fss", "fgh"};

		bst.addArray(keys, values);

		bst.deleteNode(bst.root, "la");
		bst.inorderRecord(bst.root);

		String[] keyList = new String[keys.length];

		ArrayList<String> expected = bst.inorderKeyList;
		expected.toArray(keyList);

		//To remove null values occurring in the list
		keyList = Arrays.stream(keyList).filter(Objects::nonNull).toArray(String[]::new);

		String[] testKeyList = {"da", "ha", "na", "ta"};

		assertEquals(true, Arrays.deepEquals(keyList, testKeyList));

	}

	@Test
	void testJsonInorder()
	{
		BST bst = new BST();

		bst.addJson();
		bst.inorderRecord(bst.root);

		String[] keyList = new String[5];

		bst.inorderKeyList.toArray(keyList);

		String[] testKeyList = {"da", "ha", "la", "na", "ta"};

		assertEquals(true, Arrays.deepEquals(keyList, testKeyList));
	}
}
