
import java.util.ArrayList;
import java.util.Arrays;

    /**
     * Array based storage for Resumes
     */
    public class ArrayStorage {

        private Resume[] storage = new Resume[10000];
        private int size = 0;

        void clear() {
            Arrays.fill(storage, null);

        }

        void save(Resume r){
            if (size < 10000) storage[size++] = r;
        }

        Resume get(String uuid) {
            for (int i = 0; i < size; i++)
                if (storage[i].uuid.equals(uuid)) return storage[i];
            return null;
        }

        void delete(String uuid) {
            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    int temp = size - i - 1;
                    if (temp > 0)
                        System.arraycopy(storage, i + 1, storage, i, temp);
                    storage[--size] = null;
                    break;

                }
            }
        }

        /**
         * @return array, contains only Resumes in storage (without null)
         */
        Resume[] getAll() {
            Resume[] result = new Resume[size];
            System.arraycopy(storage, 0, result, 0, size);
            return result;
        }

        int size() {
            return size;
        }
    }
